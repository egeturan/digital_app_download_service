import React from "react";
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

    }
  };

//go to register with router
  changeToMainPage(num) {
    
  }

  changeToRegister(num){
    
  }

  isFormValid = ({ email, password }) => email && password;

  handleInputError = (errors, inputName) => {
    return errors.some(error => error.message.toLowerCase().includes(inputName))
      ? "error"
      : "";
  };

  goToRegisterPage(num) {

  }

  goToMainPage(num){
   
  }

  render() {
    const { email, password, errors, loading } = this.state;

    return (
      <div>
        <Container textAlign="right" style={{height: 0, marginLeft: "140px", width: "auto"}}>
      <Button onClick={this.goToMainPage.bind(this, 0)}>
        HOME PAGE
      </Button>
      <Button onClick={this.goToRegisterPage.bind(this, 0)}>
        Kayıt Ol
      </Button>

       </Container>
      <Grid textAlign="center" verticalAlign="middle" className="app">
        <Grid.Column style={{ maxWidth: 450 }}>
          <Header as="h1" icon color="violet" textAlign="center">
            <Icon name="coffee" color="violet" />
            LOGIN TO ADASTORE
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
               LOGIN
            

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
           Don't you have an account <Link to="/register">Register</Link>
          </Message>
          <Message>
            Did you forget your account <Link to="/forget-password">I forgot my password</Link>
          </Message>
        </Grid.Column>

      </Grid>
     </div>
    );
  }
}

export default withRouter(Login);
