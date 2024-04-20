import axios from "axios";

export const generateTabs = async (url, token) => {
    return await axios.post('http://localhost:8080/song/generate', url, {
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        }
    });
};