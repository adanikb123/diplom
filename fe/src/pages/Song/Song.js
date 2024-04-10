import { useParams } from "react-router-dom";
import { SongInfo } from "./SongInfo";

const Song = ()=> {
    const { id } = useParams(); // получаем id песни из URL
    const song = {
      author: "John Smith",
      name: "Песня 1",
      instruments: [
        { name: "Гитара", tabImageUrl: "https://upload.wikimedia.org/wikipedia/commons/e/ea/12_bar_blues_in_A_for_guitar_in_tab.png", tabDownloadUrl: "https://example.com/guitar-tab.pdf" },
        { name: "Пианино", tabImageUrl: "https://example.com/piano-tab.jpg", tabDownloadUrl: "https://example.com/piano-tab.pdf" }
      ]
    };
  
    return (
    <SongInfo song = {song}/>
    );
};

export {Song};