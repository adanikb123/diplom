
export const getUsers = (users,currentPage,totalElements)=>{
    return{
        type:"GET_USERS",
        payload: {
            users,
            currentPage,
            totalElements,
          },
    }
} 