import {useState} from 'react';
import { UploadOutlined,FileOutlined,DeleteOutlined } from '@ant-design/icons';
import { Button, Upload,Input,Card,Typography,notification } from 'antd';
import "./style.css";
import { SongInfo } from '../Song';
import { uploadFile } from '../../services/uploadFile';
import { useAuth } from '../../hooks/useAuth';
import {useDispatch,useSelector} from "react-redux"
import { uploadFileState } from '../../store/actionCreators/uploadFileState';
import { clearFile } from '../../store/actionCreators/clearFile';
import { deleteFile } from '../../services/deleteFile';
import { generateTabs } from '../../services/generateTabs';
import { createSong } from '../../services/createSong';
import { addSong } from '../../store/actionCreators/addSong';
import { createUserSong } from '../../services/createUserSong';
import { deleteSong } from '../../store/actionCreators/deleteSong';

const {Title,Text} = Typography;
const Uploader=()=>{
  const file = useSelector(state => state.file);
  const song = useSelector(state => state.song);
  const dispatch = useDispatch();
  const user = useAuth();

  const [songName, setSongName] = useState("");
  const [author, setAuthor] = useState("");

  const handleUploadFile = async (info) => {

    try {
      const uploadedFile = await uploadFile(info, user.token);
      dispatch(uploadFileState(uploadedFile.data,true));
    } catch (error) {
      console.log(error);
    }
    
  }
  const handleGenerateTab = async () => {
    const response = await generateTabs(file.url,user.token)

    console.log(response.data);

    if (!songName || !author) {
      notification.open({
        message:"Ошибка",
        description:"Название песни или автор не должны быть пустыми",
        placement:"topLeft",
        type:"error"
   });
      return;
    }

    const {data}= await createSong(songName,author,response.data,user.token);

    dispatch(addSong(data));
    console.log(data);
 

    await createUserSong(user.id,data.id,user.token);
    notification.open({
     message:"Вы успешно загрузили песню",
     description:"Посмотреть историю загрузок можете в личном кабинете",
     placement:"topLeft",
     type:"success"
});

  };

  const handleDeleteFile = async ()=>{
    await deleteFile(file,user.token);

    dispatch(clearFile())
    dispatch(deleteSong())
  }

  return (
    <div >
      <div className='uploader-container'>
        <Card className='center-card'>
          <Title level={2}>Выберите файл</Title>
          <Upload
            name="file"
            action={handleUploadFile}
            showUploadList={false}
            maxCount={1}
          >
            <Button icon={<UploadOutlined />}>Нажмите, чтобы загрузить</Button>
          </Upload>
          {file.uploaded && (
            <div>
              <FileOutlined/>{file.name} <DeleteOutlined onClick={handleDeleteFile} style = {{color : "red"}}/> <br/> 
              <Input placeholder="Название песни" value={songName} onChange={(e) => setSongName(e.target.value)} /> <br />
              <Input placeholder="Автор" value={author} onChange={(e) => setAuthor(e.target.value)} /> <br />
              <Button type="primary" onClick={handleGenerateTab}>
                    Сгенерировать табулатуру 
              </Button>
            </div>
          
          )}
        </Card>
      </div>
      {song.isGenerated && (
        <div >
          <SongInfo song={song} />
        </div>
      )}
      
    </div>
  );

}


export {Uploader};