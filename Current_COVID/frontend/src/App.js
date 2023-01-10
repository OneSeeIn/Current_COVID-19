import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/Login";
import { useRecoilValue } from "recoil";
import { loginState } from "./store/atom";
import Main from "./components/Main";
import NotFound from "./components/NotFound";

function App() {
  const isLoggedIn = useRecoilValue(loginState);

  return (
    <div className="App">
      <BrowserRouter>
        {/* <Header /> */}
        <Routes>
          <Route path="/" element={isLoggedIn ? <Main /> : <Login />}></Route>
          <Route path="*" element={<NotFound />}></Route>
          {/* <Route path="/join" element={<Join />}></Route> */}
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
