
# gameDbApp

A simple Compose Multiplatform app to showcase game information using the IGDB API.

# Screenshots

<img src="https://github.com/user-attachments/assets/d2be1a57-b5eb-4234-8051-129b522c87f5" width="400"/>
<img src="https://github.com/user-attachments/assets/680770fd-62ed-4537-a6b8-dd15548bcef1" width="400"/>
<img src="https://github.com/user-attachments/assets/28b2f192-ffc8-4bcc-82b8-d4a949d82e49" width="800"/> 

## Features
- Shows Most Played, Now Playing, Most Visited and Trending Video Games
- Shows Game details like: Cover, Name, Date of release, Developer Company Names and many more...
- Dynamic Material 3 colors support
- Light/Dark mode support
- Simple Large Display Layout support
- AppWidget that displays a random game
- iOS support through Compose Multiplatform


## Setup

To run this project, you'll need to obtain API keys from IGDB and configure them in your project.

### Obtain API Keys:

[Create an IGDB account and create a new client.](https://api-docs.igdb.com/?shell#getting-started)


You'll receive a `CLIENT_ID` and `CLIENT_SECRET`.
Generate an AES key for encryption (e.g., using a tool like OpenSSL).
(Any alpha numeric 32 long string should be fine)

### Configure API Keys:

#### Android
Add the following lines to `local.properties` (If not present, create it in the root directory of your project), replacing the placeholders with your actual keys:
```
CLIENT_ID = ${YOUR_CLIENT_ID}
CLIENT_SECRET = ${YOUR_CLIENT_SECRET}
AES_KEY = ${YOUR_AES_KEY}
```

Note: Ensure that the `local.properties` file is excluded from your Git repository to keep your API keys secure.

#### iOS
Create a new file called `Secrets.xcconfig` and place it inside the folder `Configuration` (same folder that contains `Config.xcconfig`)
Add the following lines to it, replacing the placeholders with your actual keys:
```
CLIENT_ID = ${YOUR_CLIENT_ID}
CLIENT_SECRET = ${YOUR_CLIENT_SECRET}
```

Note: Ensure that the `Secrets.xcconfig` file is excluded from your Git repository to keep your API keys secure.


By following these steps, you should be able to successfully compile and run the project.

## License

MIT License

Copyright (c) 2025 Fabio Catinella

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
