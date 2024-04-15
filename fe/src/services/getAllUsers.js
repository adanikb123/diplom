import axios from "axios";

export const getAllUsers = async(page,pageSize,token)=>
{
    return  await axios.get('http://localhost:8080/user/all',{
        params: {
          page: page,
          size: pageSize
        },
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}` 
          }
    
      }) ;
}