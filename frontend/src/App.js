import logo from "./logo.svg";
import "./App.css";
import Login from "./components/Login";
import { useEffect, useState } from "react";
import { RecoilRoot, atom, selector, useRecoilState, useRecoilValue } from "recoil";
import { loginState } from "./store/atom";
import Main from "./components/Main";

function App() {
  const [isLogged] = useRecoilState(loginState);
  return <div className="App">{isLogged ? <Main /> : <Login />}</div>;
}

export default App;
