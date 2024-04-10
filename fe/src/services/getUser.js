import axios from "axios";

const getUser = async(email,password)=>
{
    return  await axios.post('http://localhost:8080/auth/signin',{email,password}) ;
}

export {getUser};