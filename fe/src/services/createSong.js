import axios from "axios";

export const createSong = async (songName,songAuthor,tabs, token) => {
    const request = {
        name: songName,
        author:songAuthor,
        tabs:tabs
    };
    return await axios.post('http://localhost:8080/song/new', request, {
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        }
    });
};