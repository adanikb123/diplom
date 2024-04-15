import axios from "axios";

export const getAllUsersSongs = async(page,pageSize,user)=>
{
    return await axios.get(`http://localhost:8080/song/userSong/${user.id}/all`,{
        params: {
          page: page,
          size: pageSize
        },
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${user.token}` 
          }
      }) ;
}