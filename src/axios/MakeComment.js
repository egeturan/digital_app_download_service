import React from 'react';
import axios from 'axios';

function MakeComment(props) {

  console.log(props.value);

  const comment = {
    user_id: props.user_id,
    app_id: props.app_id,
    text: props.text
  }

  axios.post(`http://localhost:8080/make_comment/`, comment )
      .then(res => {
        console.log(res);
        console.log(comment);
        
      })

  return <div></div>;
}

export default MakeComment;