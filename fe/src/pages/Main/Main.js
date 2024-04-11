import { Table } from "antd";
import {useSelector,useDispatch} from "react-redux";
import { useEffect } from "react";
import {Link} from "react-router-dom"
import "./style.css";
import { getAllSongs } from "../../services/getAllSongs";
import { getSongs } from "../../store/actionCreators/getSongs";



const Main =()=>{
    
    const pageSize = 2;
    const dispatch = useDispatch();
    const songs = useSelector(state => state.song.songs)
    const currPage = useSelector(state => state.song.currentPage)
    const total = useSelector(state => state.song.totalElements)

    // console.log(currentPage);
    // console.log(totalElements);
    useEffect(() => {
      const fetchData = async () => {
        const response = await getAllSongs(0, pageSize);
        const {number,totalElements,content} = response.data;
        console.log(number);
        dispatch(getSongs(content,number,totalElements));
 
      };
      fetchData();
    }, [dispatch]);

    const handlePageChange= async(page)=>{
      const response = await getAllSongs(page-1, pageSize);
      const {number,totalElements,content} = response.data;
      console.log(number);
      dispatch(getSongs(content,number,totalElements));
    }

    const columns = [
      {
        title: "Автор",
        dataIndex: "author",
        key: "author",
      },
      {
        title: "Название песни",
        dataIndex: "name",
        key: "name",
        render: (text, record) => (
          <Link to={`/song/${record.id}`}>{text}</Link>
        ),
      },
      {
        title: "Название инструмента",
        key: "tabs",
        render: (text, record) => (
          <>
            {record.tabs.map((tab) => (
              <div key={tab.id}>
                 <Link to={tab.url}>{tab.instrumentName}</Link>
              </div>
            ))}
          </>
        ),
      },
    ];
    return(
            <Table 
             rowClassName="myRow"
             columns={columns} 
             dataSource={songs} 
             bordered={true}
             pagination={{ 
              total:total,
              current: currPage+1,
              pageSize,
              onChange:handlePageChange 
            }} />   
    )
}

export {Main};