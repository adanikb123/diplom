import {useState} from 'react';
import { UploadOutlined } from '@ant-design/icons';
import { Button, Upload,message,Card,Typography } from 'antd';
import "./style.css";
import { SongInfo } from '../Song';

const {Title,Text} = Typography;
const Uploader=()=>{
  const [fileList, setFileList] = useState([]);
  const [fileUploaded, setFileUploaded] = useState(false);
  const [showSongInfo, setShowSongInfo] = useState(false);
  const song = {
    author: "John Test",
    name: "Песня 1",
    instruments: [
      { name: "Гитара", tabImageUrl: "https://upload.wikimedia.org/wikipedia/commons/e/ea/12_bar_blues_in_A_for_guitar_in_tab.png", tabDownloadUrl: "https://example.com/guitar-tab.pdf" },
      { name: "Пианино", tabImageUrl: "https://example.com/piano-tab.jpg", tabDownloadUrl: "https://example.com/piano-tab.pdf" }
    ]
  };

  const handleUploadChange = ({ fileList: newFileList }) => {
    setFileList(newFileList);
    setFileUploaded(true)
  };
  const onPreview = async (file) => {
    let src = file.url;
    if (!src) {
      src = await new Promise((resolve) => {
        const reader = new FileReader();
        reader.readAsDataURL(file.originFileObj);
        reader.onload = () => resolve(reader.result);
      });
    }
    const image = new Image();
    image.src = src;
    const imgWindow = window.open(src);
    imgWindow?.document.write(image.outerHTML);
  };

  const handleGenerateTab = () => {
  
    setShowSongInfo(true);
    console.log(song);
  };

  return (
    <div >
      <div className='uploader-container'>
        <Card className='center-card'>
          <Title level={2}>Выберите файл</Title>
          <Upload
            name="file"
            action="https://660d2bd96ddfa2943b33731c.mockapi.io/api/upload"
            fileList={fileList}
            onChange={handleUploadChange}
            onPreview={onPreview}
          >
            <Button icon={<UploadOutlined />}>Нажмите, чтобы загрузить</Button>
          </Upload>
          {fileUploaded && (
            <Button type="primary" onClick={handleGenerateTab}>
              Сгенерировать табулатуру 
            </Button>
          )}
        </Card>
      </div>
      {showSongInfo && (
        <div >
          <SongInfo song={song} />
        </div>
      )}
      
    </div>
  );

}


export {Uploader};