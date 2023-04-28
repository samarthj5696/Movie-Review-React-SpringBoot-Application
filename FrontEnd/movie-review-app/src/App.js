import "./App.css";
import AxiosConfig from "./api/AxiosConfig";
import React from "react";
import { useEffect } from "react";
import Layout from "./component/Layout";
import { Routes, Route } from "react-router-dom";
import Home from "./component/home/Home";
import Header from "./component/header/Header";
import Trailer from "./trailer/Trailer";
import Reviews from "./component/review/Reviews";

function App() {
  const [movies, setMovies] = React.useState();
  const [movie, setMovie] = React.useState();
  const [reviews, setReviews] = React.useState();
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

  const getMovieData = async (movieId) => {
    console.log("count");
    try {
      const response = await AxiosConfig.get(`/api/vi/movies/${movieId}`);
      const singleMovie = response.data.reviews;
      console.log("response", response.data.reviews);
      setMovie(response.data);
      setReviews(singleMovie);
    } catch (e) {}
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
          <Route path="/Trailer/:ytTrailerId" element={<Trailer />}></Route>
          <Route
            path="/Reviews/:movieId"
            element={
              <Reviews
                {...console.log("bbbb", reviews)}
                getMovieData={getMovieData}
                movie={movie}
                reviews={!!reviews ? reviews : []}
                setReviews={setReviews}
              />
            }
          ></Route>
        </Route>
      </Routes>
    </div>
  );
}

export default App;
