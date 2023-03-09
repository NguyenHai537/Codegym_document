import { BrowserRouter, Routes, Route } from "react-router-dom";
import Category from "./components/Category";
import Users from "./components/Users";
import Edit from "./components/editUser";
import AddUser from "./components/addUser";
import GetUsers from "./components/Users-Axios"
import UserDetails from "./components/UserDetail";
import Login from "./components/Login";
import { Provider } from "react-redux";
import store from "./redux/store";
import User from "./components/UserRedux";


function App() {
  return (
    <Provider store={store}>
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Login />} />
          <Route path="/users" element={<User />} />
        </Routes>
      </BrowserRouter>
    </Provider>
  );
}
export default App;

// import React from 'react';

// class App extends React.Component {
//    constructor(props) {
//       super(props);
		
//       this.state = {
//          header: "Header from state...",
//          content: "Content from state..."
//       }
//    }
//    render() {
//       return (
//          <div>
//             <h1>{this.state.header}</h1>
//             <h2>{this.state.content}</h2>
//          </div>
//       );
//    }
// }
// export default App;
