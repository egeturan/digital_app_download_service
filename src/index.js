import React from "react";
import ReactDOM from "react-dom";
import Login from "./components/Auth/Login";
import Register from "./components/Auth/Register";
import RegisterDeveloper from "./components/Auth/RegisterDeveloper";
import RegisterEditor from "./components/Auth/RegisterEditor";
import Spinner from "./Spinner";
import registerServiceWorker from "./registerServiceWorker";
import Apprenderer from './AppRenderer.js';
import axios from 'axios';
import GLOBAL from './global.js';
import ApplicationInformationPage from './ApplicationInformationPage';

import "semantic-ui-css/semantic.min.css";

import {
  BrowserRouter as Router,
  Switch,
  Route,
  withRouter
} from "react-router-dom";

import { createStore } from "redux";
import { Provider, connect } from "react-redux";
import { composeWithDevTools } from "redux-devtools-extension";
import rootReducer from "./reducers";
import { setUser, clearUser } from "./actions";
import HomePage from "./Homepage";
import Homepage2 from "./Homepage2";

const store = createStore(rootReducer, composeWithDevTools());

class Root extends React.Component {
  componentDidMount() {
   
    /*
    axios.get(`http://localhost:8080/isAuthenticated`)
    .then(response => {
      let user = {students: response.data};
      user = null;
      if(user){
        console.log("User is authenticated");
        this.props.setUser(user);
        this.props.history.push("/personal");
      }else{
        console.log("User is not defined");
      }
  
    })*/
   
  }

  render() {
    return false ? (
      <Spinner />
    ) : (
      <Switch>
        <Route exact path="/" component={Apprenderer} />
        <Route path="/login" component={Login} />
        <Route path="/register" component={Register} />
        <Route path="/home-page" component={HomePage} />
        <Route path="/register-editor" component={RegisterEditor} />
        <Route path="/register-developer" component={RegisterDeveloper} />
        <Route path="/app-information" component={ApplicationInformationPage} />
      </Switch>
    );
  }
}

export default Root;

const mapStateFromProps = state => ({
  isLoading: state.user.isLoading
});

const RootWithAuth = withRouter(
  connect(
    mapStateFromProps,
    { setUser, clearUser }
  )(Root)
);

ReactDOM.render(
  <Provider store={store}>
    <Router>
      <RootWithAuth />
    </Router>
  </Provider>,
  document.getElementById("root")
);
registerServiceWorker();
