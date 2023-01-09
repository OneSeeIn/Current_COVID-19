import "./App.css";
import Login from "./components/Login";
import { useRecoilValue } from "recoil";
import { loginState } from "./store/atom";
import Main from "./components/Main";

function App() {
  const isLoggedIn = useRecoilValue(loginState);
  console.log(isLoggedIn);
  return <div className="App">{isLoggedIn ? <Main /> : <Login />}</div>;
}

export default App;
