import axios from "axios";

export const uploadFile = async (file, token) => {
  const formData = new FormData();
  formData.append("file", file);


  return await axios.post("http://localhost:8080/file/upload", formData, {
    headers: {
      "Content-Type": "multipart/form-data",
      "Authorization": `Bearer ${token}`,
    },
  });
};