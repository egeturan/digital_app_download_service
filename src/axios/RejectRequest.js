import React from 'react';
import axios from 'axios';

function RejectRequest(props) {

    console.log(props.value);

    const app = {
        editor_id: props.editor_id,
        app_id: props.app_id
    }

    axios.post(`http://localhost:8080/reject_request/`, app )
        .then(res => {
            console.log(res);
            console.log(app);

        })

    return <div></div>;
}

export default RejectRequest;