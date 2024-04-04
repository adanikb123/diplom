import { HeaderMain } from "../../components/Header"
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Login,Reg ,Song, Main, UserManager, PersonalAccount} from '../'


const App = () => {
    return (
      <Router>
        <HeaderMain>
          <Routes>
            <Route path="/login" element={<Login/>}/>

            <Route path="/registration" element={<Reg/>}/>

            <Route path="/home" element={<Main/>}/>

            <Route path="/user/:userId" element={<PersonalAccount/>}/>

            <Route path="/song/:songId" element={<Song/>}/>

            <Route path="/users" element={<UserManager/>}/>

            <Route path="/songs" element={<Main/>}/>
          </Routes>

        </HeaderMain>

      </Router>
  )
}

export {App};