import React from 'react'
import { Button, Comment, Form, Header } from 'semantic-ui-react'
import matt from './assets/images/matt.jpg';
import joe from './assets/images/joe.jpg';
import elliot from './assets/images/elliot.jpg';
import jenny from './assets/images/jenny.jpg';

class AppComments extends React.Component {

    state = {
        showDisplay: 0
    };


    render(){


        let commentData = (
          <div style={{marginTop: "100px"}}>
  <Comment.Group>
    <Header as='h3' dividing>
      Comments
    </Header>

    <Comment>
      <Comment.Avatar src={matt}/>
      <Comment.Content>
        <Comment.Author as='a'>Ege Turan</Comment.Author>
        <Comment.Metadata>
          <div>Today at 5:42PM</div>
        </Comment.Metadata>
        <Comment.Text>Very useful application for communication!</Comment.Text>
        <Comment.Actions>
          <Comment.Action>Reply</Comment.Action>
        </Comment.Actions>
      </Comment.Content>
    </Comment>

    <Comment>
      <Comment.Avatar src={joe}/>
      <Comment.Content>
        <Comment.Author as='a'>Ata Coşkun</Comment.Author>
        <Comment.Metadata>
          <div>Yesterday at 12:30AM</div>
        </Comment.Metadata>
        <Comment.Text>
          <p>This app has been very useful for my research. Thanks as well!</p>
        </Comment.Text>
        <Comment.Actions>
          <Comment.Action>Reply</Comment.Action>
        </Comment.Actions>
      </Comment.Content>
      <Comment.Group>
        <Comment>
          <Comment.Avatar src={jenny} />
          <Comment.Content>
            <Comment.Author as='a'>Melike Arslan</Comment.Author>
            <Comment.Metadata>
              <div>Just now</div>
            </Comment.Metadata>
            <Comment.Text>Ege you are always so right :)</Comment.Text>
            <Comment.Actions>
              <Comment.Action>Reply</Comment.Action>
            </Comment.Actions>
          </Comment.Content>
        </Comment>
      </Comment.Group>
    </Comment>

    <Comment>
      <Comment.Avatar src={elliot} />
      <Comment.Content>
        <Comment.Author as='a'>Çağrı Orhan</Comment.Author>
        <Comment.Metadata>
          <div>5 days ago</div>
        </Comment.Metadata>
        <Comment.Text>This app is awesome. Thanks so much</Comment.Text>
        <Comment.Actions>
          <Comment.Action>Reply</Comment.Action>
        </Comment.Actions>
      </Comment.Content>
    </Comment>

    <Form reply>
      <Form.TextArea />
      <Button content='Add Reply' labelPosition='left' icon='edit' primary />
    </Form>
  </Comment.Group>
  </div>

        );


        return (
            <div>
                {commentData}
                </div>
        );




    };

}

export default AppComments;