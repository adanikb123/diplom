export const clearSongs = ()=>{
    return{
        type:"CLEAR_SONGS",
        payload:{
            songs:null,
            currentPage :null,
            totalElements:null,
        }
    }
} 