export const uploadFileState = (file,uploaded)=>{
    return{
        type:"UPLOADED_FILE",
        payload:{
            id:file.id,
            name:file.name,
            url:file.url,
            uploaded}
    }
} 