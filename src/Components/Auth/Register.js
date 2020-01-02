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
import { Link, Route, withRouter } from "react-router-dom";


class Register extends React.Component {
  state = {
    username: "",
    surname: "",
    date: "",
    email: "",
    password: "",
    passwordConfirmation: "",
    errors: [],
    loading: false
  };

  isFormValid = () => {
    let errors = [];
    let error;

    if (this.isFormEmpty(this.state)) {
      error = { message: "Fill in all fields" };
      this.setState({ errors: errors.concat(error) });
      return false;
    } else if (!this.isPasswordValid(this.state)) {
      error = { message: "Password is invalid" };
      this.setState({ errors: errors.concat(error) });
      return false;
    } else {
      return true;
    }
  };

  isFormEmpty = ({ username, surname, date, email, password, passwordConfirmation }) => {
    return (
      !username.length ||
      !surname.length ||
      !date.length ||
      !email.length ||
      !password.length ||
      !passwordConfirmation.length
    );
  };

  isPasswordValid = ({ password, passwordConfirmation }) => {
    if (password.length < 6 || passwordConfirmation.length < 6) {
      return false;
    } else if (password !== passwordConfirmation) {
      return false;
    } else {
      return true;
    }
  };

  displayErrors = errors =>
    errors.map((error, i) => <p key={i}>{error.message}</p>);

  handleChange = event => {
    this.setState({ [event.target.name]: event.target.value });
  };

  handleSubmit = event => {
    event.preventDefault();
    if (this.isFormValid()) {
      this.setState({ errors: [], loading: true });
      const user = {
        username: this.state.username,
        surname: this.state.surname,
        date: this.state.date,
        email: this.state.email,
        password: this.state.password
      };

      console.log(user);

      axios.post(`http://localhost:8080/registerUser/`, user )
      .then(res => {
        console.log(res);
        /*
        GLOBAL.userG = res.data;
        console.log("Global is: " + GLOBAL.userG);
        */
       if(res.data.situation === 1){
        this.props.history.push("/login");
      }else{
        this.setState({ errors: [], loading: false });          
      }
       
        
      })
     
    }
    this.setState({ errors: [], loading: false });     
    


  };

  saveUser = createdUser => {
    return this.state.usersRef.child(createdUser.user.uid).set({
      name: createdUser.user.displayName,
      avatar: createdUser.user.photoURL
    });
  };

  handleInputError = (errors, inputName) => {
    return errors.some(error => error.message.toLowerCase().includes(inputName))
      ? "error"
      : "";
  };

  goToLoginPage(num) {
    this.props.history.push("/login");
  }

  goToMainPage(num){
    this.props.history.push("/");
  }

  render() {
    const {
      username,
      surname,
      date,
      email,
      password,
      passwordConfirmation,
      errors,
      loading
    } = this.state;

    return (
      <div>
        <Container textAlign="right" style={{height: 0, marginLeft: "140px", width: "auto"}}>
          <Button onClick={this.goToMainPage.bind(this, 0)}>
          HomePage
          </Button>
          <Button onClick={this.goToLoginPage.bind(this, 0)}>
          Sign-In
          </Button>
       </Container>
      <Grid textAlign="center" verticalAlign="middle" className="app">
        <Grid.Column style={{ maxWidth: 450 }}>
          <Header as="h1" icon color="orange" textAlign="center">
            <Icon name="coffee" color="orange" />
            User Register to AdaStore
          </Header>
          <Form onSubmit={this.handleSubmit} size="large">
            <Segment stacked>
              <Form.Input
                fluid
                name="username"
                icon="user"
                iconPosition="left"
                placeholder="Username"
                onChange={this.handleChange}
                value={username}
                type="text"
              />

              <Form.Input
                fluid
                name="surname"
                icon="user"
                iconPosition="left"
                placeholder="surname"
                onChange={this.handleChange}
                value={surname}
                type="text"
              />

              <Form.Input
                fluid
                name="date"
                icon="user"
                iconPosition="left"
                placeholder="date"
                onChange={this.handleChange}
                value={date}
                type="text"
              />

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

              <Form.Input
                fluid
                name="passwordConfirmation"
                icon="repeat"
                iconPosition="left"
                placeholder="Re-Password"
                onChange={this.handleChange}
                value={passwordConfirmation}
                className={this.handleInputError(errors, "password")}
                type="password"
              />

              <Button
                disabled={loading}
                className={loading ? "loading" : ""}
                color="orange"
                fluid
                size="large"
              >
                Register
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
            Do yoy have an account ? <Link to="/login">Sign-In</Link>
          </Message>
          <Message>
            Register As Editor ? <Link to="/register-editor">Register as Editor</Link>
          </Message>
          <Message>
            Register as Developer ? <Link to="/register-developer">Register as Developer</Link>
          </Message>
        </Grid.Column>
      </Grid>
      </div>
    );
  }
}

export default withRouter(Register);
