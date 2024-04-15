import axios from "axios";

export const generateTabs = async (url, token) => {
    const request = {
        url: "file:///D:/work/copy/demo/diplom/fe/public" + url
    };
    return await axios.post('http://localhost:8080/song/generate', request, {
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`
        }
    });
};