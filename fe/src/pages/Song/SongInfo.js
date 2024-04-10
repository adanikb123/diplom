import { Typography, List, Image, Button } from "antd";

const { Title, Text } = Typography;
const SongInfo=({song})=>{
    return (
        <div>
          <Title level={2}>Информация о песне</Title>
          <Text strong style={{fontSize:'18px'}} >Автор: {song.author} </Text>
          <br/>
          <Text strong style={{fontSize:'18px'}}> Название песни: {song.name} </Text>
          <Title strong style={{fontSize:'18px'}} >Инструменты:</Title>
          <List
            bordered
            dataSource={song.instruments}
            renderItem={(instrument) => (
              <List.Item>
                  <div key={instrument.name}>
                  <Text style={{ fontSize: "18px" }} strong>{instrument.name}</Text>
                  <br/>
                  <Image src={instrument.tabImageUrl} alt="Табулатура" style={{ width: "300px", height: "200px" }} />
                  <br/>
                  <Button type="primary" href={instrument.tabDownloadUrl} download>
                      Скачать табулатуру для {instrument.name}
                  </Button>
                  </div>
              </List.Item>
              )}
          />
        </div>
      );
}

export {SongInfo};