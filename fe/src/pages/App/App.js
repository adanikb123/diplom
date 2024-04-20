import { BrowserRouter as Router, Route, Routes, Navigate } from "react-router-dom";
import { Login,Reg ,Song, Main, UserManager, PersonalAccount, GenerateTabs} from '../'
import LayOut  from "../../components/LayOut/LayOut";
import { RequireAuth } from "./RequireAuth";
import { ChangePassword } from "../Login";
import { Storage } from "./Storage";


const App = () => {

    return (
      <Router>
        <LayOut>
          <Routes>
            <Route exact path = "/" element = {<Navigate to =  "/home"/>} />
              
            <Route path="/login" element={<Login/>}/>

            <Route path="/change-password" element={<ChangePassword/>}/>

            <Route path="/registration" element={<Reg/>}/>

            <Route path="/home" element={<Main/>}/>

            <Route path="/generate-tabs" element={
            <RequireAuth>
              <GenerateTabs/>
            </RequireAuth>
       
            }/>

            <Route path="/user/:id" element={
              <RequireAuth>
                  <PersonalAccount/>
              </RequireAuth>
          
            }/>

            <Route path="/song/:id" element={
              <RequireAuth>
                  <Song/>
              </RequireAuth>
         
            }/>

            <Route path="/storage/*" element={
            <RequireAuth>
              <Storage/>
            </RequireAuth>}/>

            <Route path="/users" element={
              <RequireAuth>
                  <UserManager/>
              </RequireAuth>
          
            }/> 
         
          </Routes>

        </LayOut>

      </Router>
  )
}

export {App};