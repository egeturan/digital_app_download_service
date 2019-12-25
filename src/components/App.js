import React from "react";
import { Grid } from "semantic-ui-react";
import "./App.css";
import { connect } from "react-redux";
import { Link } from "react-router-dom";
import ReturnToMain from '../ReturnToMain';
import Button from "react-bootstrap/Button";

// prettier-ignore
/*
  <ColorPanel
      key={currentUser && currentUser.name}
      currentUser={currentUser}
    />
*/
const App = ({ currentUser, currentChannel, isPrivateChannel, userPosts, primaryColor, secondaryColor }) => (

  <Grid columns="equal" className="app" style={{ background: secondaryColor }}>
  
  </Grid>
);

const mapStateToProps = state => ({
  currentUser: state.user.currentUser,
  currentChannel: state.channel.currentChannel,
  isPrivateChannel: state.channel.isPrivateChannel,
  userPosts: state.channel.userPosts,
  primaryColor: state.colors.primaryColor,
  secondaryColor: state.colors.secondaryColor
});

export default connect(mapStateToProps)(App);
