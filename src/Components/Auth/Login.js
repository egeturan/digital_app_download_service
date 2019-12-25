import React from "react";
import axios from 'axios';
import GLOBAL from '../../global';

import {
  Grid,
  Form,
  Segment,
  Button,
  Header,
  Message,
  Icon,
  Container
} from "semantic-ui-react";
import { Link, withRouter } from "react-router-dom";

class Login extends React.Component {
  state = {
    email: "",
    password: "",
    errors: [],
    loading: false
  };

  displayErrors = errors =>
    errors.map((error, i) => <p key={i}>{error.message}</p>);

  handleChange = event => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = event => {
    event.preventDefault();
    if (this.isFormValid(this.state)) {
      this.setState({ errors: [], loading: true });
      const user = {
        email: this.state.email,
        password: this.state.password
      };

      console.log(user);

      axios.post(`http://localhost:8080/login`, user )
      .then(res => {
        console.log(res);
        console.log("Response is: " + res.data.situation);

        if(res.data.situation === 1){
          console.log(res.data.hashData);
          GLOBAL.screen = res.data.hashData;
          console.log("global is: " + GLOBAL.screen);
       /*   this.props.history.push({
            pathname: '/auth-controller',
            state: { detail: res.data.hashData }
          })*/
        }else{
          this.setState({ errors: [], loading: false });          
        }
        
      })
      
    }

    this.setState({ errors: [], loading: false });
  };

//go to register with router
  changeToMainPage(num) {
    this.props.history.push("/home-page");
  }

  changeToRegister(num){
    this.props.history.push("/register");
  }

  isFormValid = ({ email, password }) => email && password;

  handleInputError = (errors, inputName) => {
    return errors.some(error => error.message.toLowerCase().includes(inputName))
      ? "error"
      : "";
  };

  goToRegisterPage(num) {
    this.props.history.push("/register");
  }

  goToMainPage(num){
    this.props.history.push("/home-page");
  }

  render() {
    const { email, password, errors, loading } = this.state;

    return (
      <div>
        <Container textAlign="right" style={{height: 0, marginLeft: "140px", width: "auto"}}>
      <Button onClick={this.goToMainPage.bind(this, 0)}>
        Home Page
      </Button>
      <Button onClick={this.goToRegisterPage.bind(this, 0)}>
        Register as User
      </Button>

       </Container>
      <Grid textAlign="center" verticalAlign="middle" className="app">
        <Grid.Column style={{ maxWidth: 450 }}>
          <Header as="h1" icon color="violet" textAlign="center">
            <Icon name="coffee" color="violet" />
            Sign-in to Adastore
          </Header>
          <Form onSubmit={this.handleSubmit} size="large">
            <Segment stacked>
              <Form.Input
                fluid
                name="email"
                icon="mail"
                iconPosition="left"
                placeholder="Email Address"
                onChange={this.handleChange}
                value={email}
                className={this.handleInputError(errors, "email")}
                type="email"
              />

              <Form.Input
                fluid
                name="password"
                icon="lock"
                iconPosition="left"
                placeholder="Password"
                onChange={this.handleChange}
                value={password}
                className={this.handleInputError(errors, "password")}
                type="password"
              />

              <Button
                disabled={loading}
                className={loading ? "loading" : ""}
                color="violet"
                fluid
                size="large"
                style={{marginTop: "1px"}}
              >
                Sign-up
              </Button>
 
            </Segment>
          </Form>
          {errors.length > 0 && (
            <Message error>
              <h3>Error</h3>
              {this.displayErrors(errors)}
            </Message>
          )}
          <Message>
            Don't you have an account? <Link to="/register">Sign-up as User</Link>
          </Message>
          <Message>
            Don't you have an account? <Link to="/register-editor">Sign-up as Editor</Link>
          </Message>
          <Message>
            Don't you have an account? <Link to="/register-developer">Sign-up as Developer</Link>
          </Message>

        </Grid.Column>

      </Grid>
     </div>
    );
  }
}

export default withRouter(Login);
