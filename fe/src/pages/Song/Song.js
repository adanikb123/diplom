import { useParams } from "react-router-dom";
import { SongInfo } from "./SongInfo";
import {useSelector} from "react-redux";

const Song = ()=> {
    const { id } = useParams(); // получаем id песни из URL
    const songs = useSelector(state=>state.songs.songs);
    console.log(songs)
    const song = songs.find(song => song.id == id);

    console.log(songs)
    console.log(song)
    console.log(id)
    //https://upload.wikimedia.org/wikipedia/commons/e/ea/12_bar_blues_in_A_for_guitar_in_tab.png

    return (
    <SongInfo song = {song}/>
    );
};

export {Song};