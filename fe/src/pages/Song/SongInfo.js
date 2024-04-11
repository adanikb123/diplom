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
            dataSource={song.tabs}
            renderItem={(tab) => (
              <List.Item>
                  <div key={tab.id}>
                  <Text style={{ fontSize: "18px" }} strong> {tab.instrumentName}</Text>
                  <br/>
                  <Image src={tab.url} alt="Табулатура" style={{ width: "300px", height: "200px" }} />
                  <br/>
                  <Button type="primary" href={tab.url} download>
                      Скачать табулатуру для {tab.instrumentName}
                  </Button>
                  </div>
              </List.Item>
              )}
          />
        </div>
      );
}

export {SongInfo};