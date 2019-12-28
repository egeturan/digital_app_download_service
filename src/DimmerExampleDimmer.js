import React, { Component } from 'react'
import { Button, Dimmer, Header, Image, Segment } from 'semantic-ui-react'
import profile from './assets/images/profile.png';

export default class DimmerExampleDimmer extends Component {
  state = {}

  handleShow = () => this.setState({ active: true })
  handleHide = () => this.setState({ active: false })

  render() {
    const { active } = this.state

    return (
      <div style={{marginLeft: "200px"}}>
        <Dimmer.Dimmable as={Segment} dimmed={active}>
          <Header as='h3'>Overlayable Section</Header>
          <Image.Group size='small' className='ui small images'>
            <Image src={profile}/>
            <Image src={profile} />
            <Image src={profile} />
            <Image src={profile}/>
            <Image src={profile}/>
            <Image src={profile}/>

          </Image.Group>
          <Image size='medium' src={profile} />

          <Dimmer active={active} onClickOutside={this.handleHide} />
        </Dimmer.Dimmable>

        <Button.Group>
          <Button icon='plus' onClick={this.handleShow} />
          <Button icon='minus' onClick={this.handleHide} />
        </Button.Group>
      </div>
    )
  }
}