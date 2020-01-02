
import React from 'react';
import axios from 'axios';
import GLOBAL from '../global';

function GetUser(props) {

  console.log(props.value);

  const user = {
    user_id: props.user_id
  }

  axios.post(`http://localhost:8080/get_User/`, user )
      .then(res => {
        console.log(res);
        console.log(user);
        
      })

  return <div></div>;
}

export default GetUser;