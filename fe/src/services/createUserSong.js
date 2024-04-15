import axios from "axios";

export const createUserSong = async (userId,songId, token) => {
    const request = {
        userId: userId,
        songId:songId,
    };
    console.log(request);
    return await axios.post('http://localhost:8080/song/userSong/new', request, {
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        }
    });
};