
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Login,Reg ,Song, Main, UserManager, PersonalAccount, GenerateTabs} from '../'
import LayOut  from "../../components/LayOut/LayOut";


const App = () => {
    return (
      <Router>
        <LayOut>
          <Routes>
            <Route path="/login" element={<Login/>}/>

            <Route path="/registration" element={<Reg/>}/>

            <Route path="/home" element={<Main/>}/>

            <Route path="/generate-tabs" element={<GenerateTabs/>}/>

            <Route path="/user/:userId" element={<PersonalAccount/>}/>

            <Route path="/song/:songId" element={<Song/>}/>

            <Route path="/users" element={<UserManager/>}/>
          </Routes>

        </LayOut>

      </Router>
  )
}

export {App};