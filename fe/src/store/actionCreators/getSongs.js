

export const getSongs = (songs,currentPage,totalElements)=>{
    return{
        type:"GET_SONGS",
        payload: {
            songs,
            currentPage,
            totalElements,
          },
    }
} 