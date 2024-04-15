const initialState = {
    id:null,
    name:null,
    url:null,
    uploaded:false
}

const UPLOADED = "UPLOADED_FILE";
const CLEAR = "CLEAR_FILE"
export const fileReducer =(state = initialState,action)=>{

    switch(action.type){
        case UPLOADED:{
            const { id,name,url,uploaded} = action.payload;
            console.log(id)
            console.log(name)
            console.log(url)
            return{...state,id,name,url,uploaded};
        }
        case CLEAR:{
            const { id,name,url,uploaded} = action.payload;
            return{...state,id,name,url,uploaded};
        }
        default:
            return state;
    }
}
