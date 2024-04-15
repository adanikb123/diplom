import axios from "axios";

export const getUserByEmail = async(email)=>
{
    return  await axios.get(`http://localhost:8080/user/find/${email}`) ;
}
