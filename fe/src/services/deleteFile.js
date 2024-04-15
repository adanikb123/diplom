import axios from "axios";

export const deleteFile = async (file, token) => {
    const request = {
        id:file.id,
        name:file.name,
        url:file.url
    }
  return await axios.delete("http://localhost:8080/file/delete", { data: request,
   headers: { 
    'Content-Type': 'application/json',
    "Authorization": `Bearer ${token}` } });
};