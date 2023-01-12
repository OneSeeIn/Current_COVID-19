import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/Login";
import { useRecoilState, useRecoilValue } from "recoil";
import { loginState } from "./store/atom";
import Main from "./components/Main";
import NotFound from "./components/NotFound";
import Header from "./components/Header";
import { ThemeProvider, createTheme } from "@mui/material/styles";
import CssBaseline from "@mui/material/CssBaseline";
import { Fab, Icon, IconButton, useMediaQuery, Zoom } from "@mui/material";
import { useEffect, useMemo, useState } from "react";
import Brightness4Icon from "@mui/icons-material/Brightness4";
import Brightness7Icon from "@mui/icons-material/Brightness7";

function App() {
  const isLoggedIn = useRecoilValue(loginState);
  const prefersDarkMode = useMediaQuery("(prefers-color-scheme: dark)");
  const [mode, setMode] = useState(prefersDarkMode ? "dark" : "light");
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
  const transitionDuration = {
    enter: theme.transitions.duration.enteringScreen,
    exit: theme.transitions.duration.leavingScreen,
  };
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
        </BrowserRouter>
      </ThemeProvider>
      {fabs.map((fab, index) => (
        <Zoom
          key={fab.theme}
          in={mode === fab.theme}
          timeout={transitionDuration}
          style={{
            transitionDelay: `${mode === fab.theme ? transitionDuration.exit : 0}ms`,
          }}
          unmountOnExit
        >
          <Fab sx={{ ml: 1, position: "absolute", bottom: 16, right: 16 }} onClick={colorMode.toggleColorMode} color={fab.color}>
            {fab.icon}
          </Fab>
        </Zoom>
      ))}
    </div>
  );
}

export default App;

const fabs = [
  {
    theme: "dark",
    sx: {
      position: "absolute",
      bottom: 16,
      right: 16,
    },
    icon: <Brightness7Icon />,
    color: "dark",
  },
  {
    theme: "light",
    sx: {
      position: "absolute",
      bottom: 16,
      right: 16,
    },
    icon: <Brightness4Icon />,
    color: "primary",
  },
];
