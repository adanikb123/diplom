import axios from "axios";

export const getAllSongs = async(page,pageSize)=>
{
    return  await axios.get('http://localhost:8080/song/all',{
        params: {
          page: page,
          size: pageSize
        }
      }) ;
}