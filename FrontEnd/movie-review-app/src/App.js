import "./App.css";
import AxiosConfig from "./api/AxiosConfig";
import React from "react";
import { useEffect } from "react";
import Layout from "./component/Layout";
import { Routes, Route } from "react-router-dom";
import Home from "./component/home/Home";
import Header from "./component/header/Header";

function App() {
  const [movies, setMovies] = React.useState();
  const getMovies = async () => {
    try {
      const response = await AxiosConfig.get("/api/vi/movies/all");
      setMovies(response.data);
      console.log(response.data);
      // console.log(movies);
    } catch (e) {
      console.log(e);
    }
  };

  useEffect(() => {
    getMovies();
  }, []);

  return (
    // <></>
    <div className="App">
      <Header />
      <Routes>
        <Route path="/" element={<Layout />}>
          <Route path="/" element={<Home movies={movies} />}></Route>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
