export const logout = ()=>{
    return{
        type:"LOG_OUT",
        payload:{
            email:null,
            name:null,
            token:null,
            role:null,
            id:null
        }
    }
} 