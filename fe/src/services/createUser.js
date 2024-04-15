import axios from "axios";

const createUser = async(email,name,password)=>
{
    const request = {
        name:name,
        email:email,
        password:password,
        role:"USER"};
    return  await axios.post('http://localhost:8080/auth/new',request) ;
}

export {createUser};