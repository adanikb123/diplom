export const deleteSong = ()=>{
    return{
        type:"DELETE_SONG",
        payload:{
            author:null,
            name:null,
            id:null,
            tabs:[],
            isGenerated:false,
        }
    }
} 