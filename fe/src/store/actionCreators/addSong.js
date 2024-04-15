export const addSong = (song)=>{
    return{
        type:"ADD_SONG",
        payload:{
            id:song.id,
            author:song.author,
            name:song.name,
            tabs:song.tabs,
            isGenerated:true,
        }
    }
} 