import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/Login";
import { useRecoilValue } from "recoil";
import { loginState } from "./store/atom";
import Main from "./components/Main";
import NotFound from "./components/NotFound";
import Header from "./components/Header";
import { ThemeProvider, createTheme } from "@mui/material/styles";
import CssBaseline from "@mui/material/CssBaseline";
import { IconButton } from "@mui/material";
import { useMemo, useState } from "react";

function App() {
  const isLoggedIn = useRecoilValue(loginState);

  const [mode, setMode] = useState("light");
  const colorMode = useMemo(
    () => ({
      toggleColorMode: () => {
        setMode((prevMode) => (prevMode === "light" ? "dark" : "light"));
      },
    }),
    []
  );

  const theme = useMemo(
    () =>
      createTheme({
        palette: {
          mode,
        },
      }),
    [mode]
  );
  console.log(theme.palette.mode);
  return (
    <div className="App">
      <ThemeProvider theme={theme}>
        <CssBaseline />
        <BrowserRouter>
          <Header />
          <Routes>
            <Route path="/" element={isLoggedIn ? <Main /> : <Login />}></Route>
            <Route path="*" element={<NotFound />}></Route>
            {/* <Route path="/join" element={<Join />}></Route> */}
          </Routes>
          <IconButton sx={{ ml: 1 }} onClick={colorMode.toggleColorMode} color="inherit">
            {console.log(theme.palette.mode === "dark" ? "다크" : "라이트")}
            {theme.palette.mode === "dark" ? "다크" : "라이트"}
          </IconButton>
        </BrowserRouter>
      </ThemeProvider>
    </div>
  );
}

export default App;
