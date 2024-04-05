import { Table } from "antd";
import "./style.css";


const Main =()=>{
const columns = [
    { 
        title: "Author",
        dataIndex:"author",
        key:"author"
    },
    { 
        title: "Song name",
        dataIndex:"name",
        key:"name",
        render: (text) => <a>{text}</a>
    
    },
    { 
        title: "Instrument name",
        dataIndex:"instrumentName",
        key:"instrumentName",
        render: (instrumentName) => (
            <>
            {instrumentName.map((val, index) => (
            <div key={index}>{val}</div>
            ))}
            </>
        )
        
    },
    { 
        title: "Tabs",
        dataIndex:"tabs",
        key:"tabs",
        render: (tabs) => (
            <>
            {tabs.map((val, index) => (
            <div key={index}>{val}</div>
            ))}
            </>
        )
    },
];
const data = [
    {
      key:1,
      author: "John Smith",
      name: "Song 1",
      instrumentName: ["Guitar", "Piano"],
      tabs: ["Tab 1", "Tab 2"]
    },
    {
      key:2,
      author: "Jane Doe",
      name: "Song 2",
      instrumentName: ["Violin"],
      tabs: ["Tab 3"]
    },
    {
      key:3,  
      author: "Mike Johnson",
      name: "Song 3",
      instrumentName: ["Drums", "Bass"],
      tabs: ["Tab 4","Tab 5"]
    },
    {
        key:4,
      author: "Sarah Williams",
      name: "Song 4",
      instrumentName: ["Flute", "Saxophone"],
      tabs: ["Tab 6", "Tab 7"]
    },
    {
        key:5,
      author: "Robert Brown",
      name: "Song 5",
      instrumentName: ["Trumpet", "Trombone"],
      tabs: ["Tab 8", "Tab 9"]
    },
    {
        key:6,
      author: "Linda Wilson",
      name: "Song 6",
      instrumentName: ["Harp"],
      tabs: ["Tab 10"]
    },
    {
        key:7,
      author: "David Thompson",
      name: "Song 7",
      instrumentName: ["Organ", "Accordion"],
      tabs: ["Tab 11","Tab 12"]
    },
    {
        key:8,
      author: "Emily Clark",
      name: "Song 8",
      instrumentName: ["Cello"],
      tabs: ["Tab 13"]
    },
    {
        key:9,
      author: "Michael Turner",
      name: "Song 9",
      instrumentName: ["Xylophone", "Marimba"],
      tabs: ["Tab 14", "Tab 15"]
    },
    {
        key:10,
      author: "Olivia Walker",
      name: "Song 10",
      instrumentName: ["Bagpipes"],
      tabs: ["Tab 16"]
    }
  ];

    return(
            <Table 
             rowClassName="myRow"
             columns={columns} 
             dataSource={data} 
             bordered={true}  />
    )
}

export {Main};