
import {BrowserRouter,Routes,Route} from "react-router-dom"
import 'bootstrap/dist/css/bootstrap.min.css';
import LandingPage from "./components/LandingPage";
import Userslogin from "./components/Userslogin";
import MerchantSignUp from "./components/MerchantSignUp";
import MerchantLogin from "./components/MerchantLogin";
import MerchantHomePage from "./components/MerchantHomePage";
import UserHomePage from "./components/UserHomePage";
import UserSignUp from "./components/UserSignUp"
import Error from "./components/Error";
import Protect from "./components/Protect";



function App() {
  return (
    <div className="App">
    <BrowserRouter>
    <Routes>
     <Route path="/" element={<LandingPage/>}></Route>
     <Route path = "/merchant" element={<MerchantLogin/>}></Route>
     <Route path = "/user" element={<Userslogin/>}></Route>
     <Route path="/merchantsignup" element={<MerchantSignUp/>}></Route>
     <Route path="/merchanthomepage/*" element={<Protect Child={MerchantHomePage}/>}></Route>
     <Route path="/usersignup" element={<UserSignUp/>}></Route>
     <Route path="/userhomepage/*" element={<UserHomePage/>}></Route>
     <Route path="/*" element={<Error/>}></Route>
    </Routes>
    </BrowserRouter>
    
    </div>
  );
}

export default App;
