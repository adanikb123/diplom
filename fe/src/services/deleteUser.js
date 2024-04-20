import axios from "axios";


export const deleteUser = async (id,token) => {
  return await axios.delete(`http://localhost:8080/user/delete/${id}`, { 
   headers: { 
    'Content-Type': 'application/json',
    "Authorization": `Bearer ${token}` } });
};