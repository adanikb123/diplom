const initialState = {
    author:null,
    name:null,
    id:null,
    tabs:[],
    isGenerated:false,
}

const ADD = "ADD_SONG";
const DELETE = "DELETE_SONG";

export const songReducer =(state = initialState,action)=>{

    switch(action.type){
        case ADD:{
            const { author, name, id,tabs,isGenerated } = action.payload;
            return{...state,author,name,id,tabs,isGenerated};
        }
        case DELETE:{
            const { author, name, id,tabs,isGenerated } = action.payload;
            console.log("qwewqewqe")
            return{...state,author,name,id,tabs,isGenerated};
        }
  
        default:
            return state;
    }
}
