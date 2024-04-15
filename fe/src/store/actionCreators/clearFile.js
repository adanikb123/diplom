export const clearFile = ()=>{
    return{
        type:"CLEAR_FILE",
        payload:{
            id:null,
            name:null,
            url:null,
            uploaded:false
        }
    }
} 