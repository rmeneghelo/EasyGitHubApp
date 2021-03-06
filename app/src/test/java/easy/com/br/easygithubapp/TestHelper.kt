package easy.com.br.easygithubapp

class TestHelper {

    companion object {
        const val API_RESPONSE_REPOSITORIES =
                "{ \"total_count\": 4665530,\n" +
                "    \"incomplete_results\": false,\n" +
                "    \"items\": [\n" +
                "        {\n" +
                "            \"id\": 22790488,\n" +
                "            \"name\": \"java-design-patterns\",\n" +
                "            \"full_name\": \"iluwatar/java-design-patterns\",\n" +
                "            \"owner\": {\n" +
                "                \"login\": \"iluwatar\",\n" +
                "                \"id\": 582346,\n" +
                "                \"avatar_url\": \"https://avatars1.githubusercontent.com/u/582346?v=4\",\n" +
                "                \"gravatar_id\": \"\",\n" +
                "                \"url\": \"https://api.github.com/users/iluwatar\",\n" +
                "                \"html_url\": \"https://github.com/iluwatar\",\n" +
                "                \"followers_url\": \"https://api.github.com/users/iluwatar/followers\",\n" +
                "                \"following_url\": \"https://api.github.com/users/iluwatar/following{/other_user}\",\n" +
                "                \"gists_url\": \"https://api.github.com/users/iluwatar/gists{/gist_id}\",\n" +
                "                \"starred_url\": \"https://api.github.com/users/iluwatar/starred{/owner}{/repo}\",\n" +
                "                \"subscriptions_url\": \"https://api.github.com/users/iluwatar/subscriptions\",\n" +
                "                \"organizations_url\": \"https://api.github.com/users/iluwatar/orgs\",\n" +
                "                \"repos_url\": \"https://api.github.com/users/iluwatar/repos\",\n" +
                "                \"events_url\": \"https://api.github.com/users/iluwatar/events{/privacy}\",\n" +
                "                \"received_events_url\": \"https://api.github.com/users/iluwatar/received_events\",\n" +
                "                \"type\": \"User\",\n" +
                "                \"site_admin\": false\n" +
                "            },\n" +
                "            \"private\": false,\n" +
                "            \"html_url\": \"https://github.com/iluwatar/java-design-patterns\",\n" +
                "            \"description\": \"Design patterns implemented in Java\",\n" +
                "            \"fork\": false,\n" +
                "            \"url\": \"https://api.github.com/repos/iluwatar/java-design-patterns\",\n" +
                "            \"forks_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/forks\",\n" +
                "            \"keys_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/keys{/key_id}\",\n" +
                "            \"collaborators_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/collaborators{/collaborator}\",\n" +
                "            \"teams_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/teams\",\n" +
                "            \"hooks_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/hooks\",\n" +
                "            \"issue_events_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/issues/events{/number}\",\n" +
                "            \"events_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/events\",\n" +
                "            \"assignees_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/assignees{/user}\",\n" +
                "            \"branches_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/branches{/branch}\",\n" +
                "            \"tags_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/tags\",\n" +
                "            \"blobs_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/git/blobs{/sha}\",\n" +
                "            \"git_tags_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/git/tags{/sha}\",\n" +
                "            \"git_refs_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/git/refs{/sha}\",\n" +
                "            \"trees_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/git/trees{/sha}\",\n" +
                "            \"statuses_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/statuses/{sha}\",\n" +
                "            \"languages_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/languages\",\n" +
                "            \"stargazers_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/stargazers\",\n" +
                "            \"contributors_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/contributors\",\n" +
                "            \"subscribers_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/subscribers\",\n" +
                "            \"subscription_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/subscription\",\n" +
                "            \"commits_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/commits{/sha}\",\n" +
                "            \"git_commits_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/git/commits{/sha}\",\n" +
                "            \"comments_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/comments{/number}\",\n" +
                "            \"issue_comment_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/issues/comments{/number}\",\n" +
                "            \"contents_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/contents/{+path}\",\n" +
                "            \"compare_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/compare/{base}...{head}\",\n" +
                "            \"merges_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/merges\",\n" +
                "            \"archive_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/{archive_format}{/ref}\",\n" +
                "            \"downloads_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/downloads\",\n" +
                "            \"issues_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/issues{/number}\",\n" +
                "            \"pulls_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/pulls{/number}\",\n" +
                "            \"milestones_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/milestones{/number}\",\n" +
                "            \"notifications_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/notifications{?since,all,participating}\",\n" +
                "            \"labels_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/labels{/name}\",\n" +
                "            \"releases_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/releases{/id}\",\n" +
                "            \"deployments_url\": \"https://api.github.com/repos/iluwatar/java-design-patterns/deployments\",\n" +
                "            \"created_at\": \"2014-08-09T16:45:18Z\",\n" +
                "            \"updated_at\": \"2018-05-13T13:32:17Z\",\n" +
                "            \"pushed_at\": \"2018-05-12T17:19:03Z\",\n" +
                "            \"git_url\": \"git://github.com/iluwatar/java-design-patterns.git\",\n" +
                "            \"ssh_url\": \"git@github.com:iluwatar/java-design-patterns.git\",\n" +
                "            \"clone_url\": \"https://github.com/iluwatar/java-design-patterns.git\",\n" +
                "            \"svn_url\": \"https://github.com/iluwatar/java-design-patterns\",\n" +
                "            \"homepage\": \"http://java-design-patterns.com\",\n" +
                "            \"size\": 17599,\n" +
                "            \"stargazers_count\": 33364,\n" +
                "            \"watchers_count\": 33364,\n" +
                "            \"language\": \"Java\",\n" +
                "            \"has_issues\": true,\n" +
                "            \"has_projects\": false,\n" +
                "            \"has_downloads\": true,\n" +
                "            \"has_wiki\": true,\n" +
                "            \"has_pages\": true,\n" +
                "            \"forks_count\": 10776,\n" +
                "            \"mirror_url\": null,\n" +
                "            \"archived\": false,\n" +
                "            \"open_issues_count\": 173,\n" +
                "            \"license\": {\n" +
                "                \"key\": \"mit\",\n" +
                "                \"name\": \"MIT License\",\n" +
                "                \"spdx_id\": \"MIT\",\n" +
                "                \"url\": \"https://api.github.com/licenses/mit\"\n" +
                "            },\n" +
                "            \"forks\": 10776,\n" +
                "            \"open_issues\": 173,\n" +
                "            \"watchers\": 33364,\n" +
                "            \"default_branch\": \"master\",\n" +
                "            \"score\": 1\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 7508411,\n" +
                "            \"name\": \"RxJava\",\n" +
                "            \"full_name\": \"ReactiveX/RxJava\",\n" +
                "            \"owner\": {\n" +
                "                \"login\": \"ReactiveX\",\n" +
                "                \"id\": 6407041,\n" +
                "                \"avatar_url\": \"https://avatars1.githubusercontent.com/u/6407041?v=4\",\n" +
                "                \"gravatar_id\": \"\",\n" +
                "                \"url\": \"https://api.github.com/users/ReactiveX\",\n" +
                "                \"html_url\": \"https://github.com/ReactiveX\",\n" +
                "                \"followers_url\": \"https://api.github.com/users/ReactiveX/followers\",\n" +
                "                \"following_url\": \"https://api.github.com/users/ReactiveX/following{/other_user}\",\n" +
                "                \"gists_url\": \"https://api.github.com/users/ReactiveX/gists{/gist_id}\",\n" +
                "                \"starred_url\": \"https://api.github.com/users/ReactiveX/starred{/owner}{/repo}\",\n" +
                "                \"subscriptions_url\": \"https://api.github.com/users/ReactiveX/subscriptions\",\n" +
                "                \"organizations_url\": \"https://api.github.com/users/ReactiveX/orgs\",\n" +
                "                \"repos_url\": \"https://api.github.com/users/ReactiveX/repos\",\n" +
                "                \"events_url\": \"https://api.github.com/users/ReactiveX/events{/privacy}\",\n" +
                "                \"received_events_url\": \"https://api.github.com/users/ReactiveX/received_events\",\n" +
                "                \"type\": \"Organization\",\n" +
                "                \"site_admin\": false\n" +
                "            },\n" +
                "            \"private\": false,\n" +
                "            \"html_url\": \"https://github.com/ReactiveX/RxJava\",\n" +
                "            \"description\": \"RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.\",\n" +
                "            \"fork\": false,\n" +
                "            \"url\": \"https://api.github.com/repos/ReactiveX/RxJava\",\n" +
                "            \"forks_url\": \"https://api.github.com/repos/ReactiveX/RxJava/forks\",\n" +
                "            \"keys_url\": \"https://api.github.com/repos/ReactiveX/RxJava/keys{/key_id}\",\n" +
                "            \"collaborators_url\": \"https://api.github.com/repos/ReactiveX/RxJava/collaborators{/collaborator}\",\n" +
                "            \"teams_url\": \"https://api.github.com/repos/ReactiveX/RxJava/teams\",\n" +
                "            \"hooks_url\": \"https://api.github.com/repos/ReactiveX/RxJava/hooks\",\n" +
                "            \"issue_events_url\": \"https://api.github.com/repos/ReactiveX/RxJava/issues/events{/number}\",\n" +
                "            \"events_url\": \"https://api.github.com/repos/ReactiveX/RxJava/events\",\n" +
                "            \"assignees_url\": \"https://api.github.com/repos/ReactiveX/RxJava/assignees{/user}\",\n" +
                "            \"branches_url\": \"https://api.github.com/repos/ReactiveX/RxJava/branches{/branch}\",\n" +
                "            \"tags_url\": \"https://api.github.com/repos/ReactiveX/RxJava/tags\",\n" +
                "            \"blobs_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/blobs{/sha}\",\n" +
                "            \"git_tags_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/tags{/sha}\",\n" +
                "            \"git_refs_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/refs{/sha}\",\n" +
                "            \"trees_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/trees{/sha}\",\n" +
                "            \"statuses_url\": \"https://api.github.com/repos/ReactiveX/RxJava/statuses/{sha}\",\n" +
                "            \"languages_url\": \"https://api.github.com/repos/ReactiveX/RxJava/languages\",\n" +
                "            \"stargazers_url\": \"https://api.github.com/repos/ReactiveX/RxJava/stargazers\",\n" +
                "            \"contributors_url\": \"https://api.github.com/repos/ReactiveX/RxJava/contributors\",\n" +
                "            \"subscribers_url\": \"https://api.github.com/repos/ReactiveX/RxJava/subscribers\",\n" +
                "            \"subscription_url\": \"https://api.github.com/repos/ReactiveX/RxJava/subscription\",\n" +
                "            \"commits_url\": \"https://api.github.com/repos/ReactiveX/RxJava/commits{/sha}\",\n" +
                "            \"git_commits_url\": \"https://api.github.com/repos/ReactiveX/RxJava/git/commits{/sha}\",\n" +
                "            \"comments_url\": \"https://api.github.com/repos/ReactiveX/RxJava/comments{/number}\",\n" +
                "            \"issue_comment_url\": \"https://api.github.com/repos/ReactiveX/RxJava/issues/comments{/number}\",\n" +
                "            \"contents_url\": \"https://api.github.com/repos/ReactiveX/RxJava/contents/{+path}\",\n" +
                "            \"compare_url\": \"https://api.github.com/repos/ReactiveX/RxJava/compare/{base}...{head}\",\n" +
                "            \"merges_url\": \"https://api.github.com/repos/ReactiveX/RxJava/merges\",\n" +
                "            \"archive_url\": \"https://api.github.com/repos/ReactiveX/RxJava/{archive_format}{/ref}\",\n" +
                "            \"downloads_url\": \"https://api.github.com/repos/ReactiveX/RxJava/downloads\",\n" +
                "            \"issues_url\": \"https://api.github.com/repos/ReactiveX/RxJava/issues{/number}\",\n" +
                "            \"pulls_url\": \"https://api.github.com/repos/ReactiveX/RxJava/pulls{/number}\",\n" +
                "            \"milestones_url\": \"https://api.github.com/repos/ReactiveX/RxJava/milestones{/number}\",\n" +
                "            \"notifications_url\": \"https://api.github.com/repos/ReactiveX/RxJava/notifications{?since,all,participating}\",\n" +
                "            \"labels_url\": \"https://api.github.com/repos/ReactiveX/RxJava/labels{/name}\",\n" +
                "            \"releases_url\": \"https://api.github.com/repos/ReactiveX/RxJava/releases{/id}\",\n" +
                "            \"deployments_url\": \"https://api.github.com/repos/ReactiveX/RxJava/deployments\",\n" +
                "            \"created_at\": \"2013-01-08T20:11:48Z\",\n" +
                "            \"updated_at\": \"2018-05-13T11:24:05Z\",\n" +
                "            \"pushed_at\": \"2018-05-09T17:30:06Z\",\n" +
                "            \"git_url\": \"git://github.com/ReactiveX/RxJava.git\",\n" +
                "            \"ssh_url\": \"git@github.com:ReactiveX/RxJava.git\",\n" +
                "            \"clone_url\": \"https://github.com/ReactiveX/RxJava.git\",\n" +
                "            \"svn_url\": \"https://github.com/ReactiveX/RxJava\",\n" +
                "            \"homepage\": \"\",\n" +
                "            \"size\": 54403,\n" +
                "            \"stargazers_count\": 32958,\n" +
                "            \"watchers_count\": 32958,\n" +
                "            \"language\": \"Java\",\n" +
                "            \"has_issues\": true,\n" +
                "            \"has_projects\": true,\n" +
                "            \"has_downloads\": true,\n" +
                "            \"has_wiki\": true,\n" +
                "            \"has_pages\": true,\n" +
                "            \"forks_count\": 5772,\n" +
                "            \"mirror_url\": null,\n" +
                "            \"archived\": false,\n" +
                "            \"open_issues_count\": 38,\n" +
                "            \"license\": {\n" +
                "                \"key\": \"apache-2.0\",\n" +
                "                \"name\": \"Apache License 2.0\",\n" +
                "                \"spdx_id\": \"Apache-2.0\",\n" +
                "                \"url\": \"https://api.github.com/licenses/apache-2.0\"\n" +
                "            },\n" +
                "            \"forks\": 5772,\n" +
                "            \"open_issues\": 38,\n" +
                "            \"watchers\": 32958,\n" +
                "            \"default_branch\": \"2.x\",\n" +
                "            \"score\": 1\n" +
                "        }"+
                "   ]" +
                "}"

        const val API_RESPONSE_REPOSITORIES_DETAILS =
                "[\n" +
                        "   {\n" +
                        "      \"url\":\"https://api.github.com/repos/ReactiveX/RxJava/pulls/6242\",\n" +
                        "      \"id\":221742942,\n" +
                        "      \"node_id\":\"MDExOlB1bGxSZXF1ZXN0MjIxNzQyOTQy\",\n" +
                        "      \"html_url\":\"https://github.com/ReactiveX/RxJava/pull/6242\",\n" +
                        "      \"diff_url\":\"https://github.com/ReactiveX/RxJava/pull/6242.diff\",\n" +
                        "      \"patch_url\":\"https://github.com/ReactiveX/RxJava/pull/6242.patch\",\n" +
                        "      \"issue_url\":\"https://api.github.com/repos/ReactiveX/RxJava/issues/6242\",\n" +
                        "      \"number\":6242,\n" +
                        "      \"state\":\"open\",\n" +
                        "      \"locked\":false,\n" +
                        "      \"title\":\"Add delaySubscription() methods to Completable #5081\",\n" +
                        "      \"user\":{\n" +
                        "         \"login\":\"soshial\",\n" +
                        "         \"id\":100644,\n" +
                        "         \"node_id\":\"MDQ6VXNlcjEwMDY0NA==\",\n" +
                        "         \"avatar_url\":\"https://avatars1.githubusercontent.com/u/100644?v=4\",\n" +
                        "         \"gravatar_id\":\"\",\n" +
                        "         \"url\":\"https://api.github.com/users/soshial\",\n" +
                        "         \"html_url\":\"https://github.com/soshial\",\n" +
                        "         \"followers_url\":\"https://api.github.com/users/soshial/followers\",\n" +
                        "         \"following_url\":\"https://api.github.com/users/soshial/following{/other_user}\",\n" +
                        "         \"gists_url\":\"https://api.github.com/users/soshial/gists{/gist_id}\",\n" +
                        "         \"starred_url\":\"https://api.github.com/users/soshial/starred{/owner}{/repo}\",\n" +
                        "         \"subscriptions_url\":\"https://api.github.com/users/soshial/subscriptions\",\n" +
                        "         \"organizations_url\":\"https://api.github.com/users/soshial/orgs\",\n" +
                        "         \"repos_url\":\"https://api.github.com/users/soshial/repos\",\n" +
                        "         \"events_url\":\"https://api.github.com/users/soshial/events{/privacy}\",\n" +
                        "         \"received_events_url\":\"https://api.github.com/users/soshial/received_events\",\n" +
                        "         \"type\":\"User\",\n" +
                        "         \"site_admin\":false\n" +
                        "      },\n" +
                        "      \"body\":\"Since Observable, Single already have `delaySubscription()`, but Completable doesn't, I added these methods to the code.\",\n" +
                        "      \"created_at\":\"2018-10-10T10:50:14Z\",\n" +
                        "      \"updated_at\":\"2018-10-12T18:36:32Z\",\n" +
                        "      \"closed_at\":null,\n" +
                        "      \"merged_at\":null,\n" +
                        "      \"merge_commit_sha\":\"198b5b136edc56ff1cd629729bc2a28497d3429c\",\n" +
                        "      \"assignee\":null,\n" +
                        "      \"assignees\":[\n" +
                        "\n" +
                        "      ],\n" +
                        "      \"requested_reviewers\":[\n" +
                        "\n" +
                        "      ],\n" +
                        "      \"requested_teams\":[\n" +
                        "\n" +
                        "      ],\n" +
                        "      \"labels\":[\n" +
                        "         {\n" +
                        "            \"id\":480313802,\n" +
                        "            \"node_id\":\"MDU6TGFiZWw0ODAzMTM4MDI=\",\n" +
                        "            \"url\":\"https://api.github.com/repos/ReactiveX/RxJava/labels/2.x\",\n" +
                        "            \"name\":\"2.x\",\n" +
                        "            \"color\":\"af40af\",\n" +
                        "            \"default\":false\n" +
                        "         },\n" +
                        "         {\n" +
                        "            \"id\":24234453,\n" +
                        "            \"node_id\":\"MDU6TGFiZWwyNDIzNDQ1Mw==\",\n" +
                        "            \"url\":\"https://api.github.com/repos/ReactiveX/RxJava/labels/Enhancement\",\n" +
                        "            \"name\":\"Enhancement\",\n" +
                        "            \"color\":\"84b6eb\",\n" +
                        "            \"default\":false\n" +
                        "         }\n" +
                        "      ],\n" +
                        "      \"milestone\":{\n" +
                        "         \"url\":\"https://api.github.com/repos/ReactiveX/RxJava/milestones/26\",\n" +
                        "         \"html_url\":\"https://github.com/ReactiveX/RxJava/milestone/26\",\n" +
                        "         \"labels_url\":\"https://api.github.com/repos/ReactiveX/RxJava/milestones/26/labels\",\n" +
                        "         \"id\":3505512,\n" +
                        "         \"node_id\":\"MDk6TWlsZXN0b25lMzUwNTUxMg==\",\n" +
                        "         \"number\":26,\n" +
                        "         \"title\":\"2.2 backlog\",\n" +
                        "         \"description\":\"Issues and tasks deferred beyond the 2.2 release.\",\n" +
                        "         \"creator\":{\n" +
                        "            \"login\":\"akarnokd\",\n" +
                        "            \"id\":1269832,\n" +
                        "            \"node_id\":\"MDQ6VXNlcjEyNjk4MzI=\",\n" +
                        "            \"avatar_url\":\"https://avatars2.githubusercontent.com/u/1269832?v=4\",\n" +
                        "            \"gravatar_id\":\"\",\n" +
                        "            \"url\":\"https://api.github.com/users/akarnokd\",\n" +
                        "            \"html_url\":\"https://github.com/akarnokd\",\n" +
                        "            \"followers_url\":\"https://api.github.com/users/akarnokd/followers\",\n" +
                        "            \"following_url\":\"https://api.github.com/users/akarnokd/following{/other_user}\",\n" +
                        "            \"gists_url\":\"https://api.github.com/users/akarnokd/gists{/gist_id}\",\n" +
                        "            \"starred_url\":\"https://api.github.com/users/akarnokd/starred{/owner}{/repo}\",\n" +
                        "            \"subscriptions_url\":\"https://api.github.com/users/akarnokd/subscriptions\",\n" +
                        "            \"organizations_url\":\"https://api.github.com/users/akarnokd/orgs\",\n" +
                        "            \"repos_url\":\"https://api.github.com/users/akarnokd/repos\",\n" +
                        "            \"events_url\":\"https://api.github.com/users/akarnokd/events{/privacy}\",\n" +
                        "            \"received_events_url\":\"https://api.github.com/users/akarnokd/received_events\",\n" +
                        "            \"type\":\"User\",\n" +
                        "            \"site_admin\":false\n" +
                        "         },\n" +
                        "         \"open_issues\":7,\n" +
                        "         \"closed_issues\":48,\n" +
                        "         \"state\":\"open\",\n" +
                        "         \"created_at\":\"2018-07-18T10:59:08Z\",\n" +
                        "         \"updated_at\":\"2018-10-12T17:07:35Z\",\n" +
                        "         \"due_on\":\"2018-12-31T08:00:00Z\",\n" +
                        "         \"closed_at\":null\n" +
                        "      },\n" +
                        "      \"commits_url\":\"https://api.github.com/repos/ReactiveX/RxJava/pulls/6242/commits\",\n" +
                        "      \"review_comments_url\":\"https://api.github.com/repos/ReactiveX/RxJava/pulls/6242/comments\",\n" +
                        "      \"review_comment_url\":\"https://api.github.com/repos/ReactiveX/RxJava/pulls/comments{/number}\",\n" +
                        "      \"comments_url\":\"https://api.github.com/repos/ReactiveX/RxJava/issues/6242/comments\",\n" +
                        "      \"statuses_url\":\"https://api.github.com/repos/ReactiveX/RxJava/statuses/cb5e8cd1d177b81ade76943ec5cbd26b34670de8\",\n" +
                        "      \"head\":{\n" +
                        "         \"label\":\"soshial:2.x\",\n" +
                        "         \"ref\":\"2.x\",\n" +
                        "         \"sha\":\"cb5e8cd1d177b81ade76943ec5cbd26b34670de8\",\n" +
                        "         \"user\":{\n" +
                        "            \"login\":\"soshial\",\n" +
                        "            \"id\":100644,\n" +
                        "            \"node_id\":\"MDQ6VXNlcjEwMDY0NA==\",\n" +
                        "            \"avatar_url\":\"https://avatars1.githubusercontent.com/u/100644?v=4\",\n" +
                        "            \"gravatar_id\":\"\",\n" +
                        "            \"url\":\"https://api.github.com/users/soshial\",\n" +
                        "            \"html_url\":\"https://github.com/soshial\",\n" +
                        "            \"followers_url\":\"https://api.github.com/users/soshial/followers\",\n" +
                        "            \"following_url\":\"https://api.github.com/users/soshial/following{/other_user}\",\n" +
                        "            \"gists_url\":\"https://api.github.com/users/soshial/gists{/gist_id}\",\n" +
                        "            \"starred_url\":\"https://api.github.com/users/soshial/starred{/owner}{/repo}\",\n" +
                        "            \"subscriptions_url\":\"https://api.github.com/users/soshial/subscriptions\",\n" +
                        "            \"organizations_url\":\"https://api.github.com/users/soshial/orgs\",\n" +
                        "            \"repos_url\":\"https://api.github.com/users/soshial/repos\",\n" +
                        "            \"events_url\":\"https://api.github.com/users/soshial/events{/privacy}\",\n" +
                        "            \"received_events_url\":\"https://api.github.com/users/soshial/received_events\",\n" +
                        "            \"type\":\"User\",\n" +
                        "            \"site_admin\":false\n" +
                        "         },\n" +
                        "         \"repo\":{\n" +
                        "            \"id\":152406747,\n" +
                        "            \"node_id\":\"MDEwOlJlcG9zaXRvcnkxNTI0MDY3NDc=\",\n" +
                        "            \"name\":\"RxJava\",\n" +
                        "            \"full_name\":\"soshial/RxJava\",\n" +
                        "            \"private\":false,\n" +
                        "            \"owner\":{\n" +
                        "               \"login\":\"soshial\",\n" +
                        "               \"id\":100644,\n" +
                        "               \"node_id\":\"MDQ6VXNlcjEwMDY0NA==\",\n" +
                        "               \"avatar_url\":\"https://avatars1.githubusercontent.com/u/100644?v=4\",\n" +
                        "               \"gravatar_id\":\"\",\n" +
                        "               \"url\":\"https://api.github.com/users/soshial\",\n" +
                        "               \"html_url\":\"https://github.com/soshial\",\n" +
                        "               \"followers_url\":\"https://api.github.com/users/soshial/followers\",\n" +
                        "               \"following_url\":\"https://api.github.com/users/soshial/following{/other_user}\",\n" +
                        "               \"gists_url\":\"https://api.github.com/users/soshial/gists{/gist_id}\",\n" +
                        "               \"starred_url\":\"https://api.github.com/users/soshial/starred{/owner}{/repo}\",\n" +
                        "               \"subscriptions_url\":\"https://api.github.com/users/soshial/subscriptions\",\n" +
                        "               \"organizations_url\":\"https://api.github.com/users/soshial/orgs\",\n" +
                        "               \"repos_url\":\"https://api.github.com/users/soshial/repos\",\n" +
                        "               \"events_url\":\"https://api.github.com/users/soshial/events{/privacy}\",\n" +
                        "               \"received_events_url\":\"https://api.github.com/users/soshial/received_events\",\n" +
                        "               \"type\":\"User\",\n" +
                        "               \"site_admin\":false\n" +
                        "            },\n" +
                        "            \"html_url\":\"https://github.com/soshial/RxJava\",\n" +
                        "            \"description\":\"RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.\",\n" +
                        "            \"fork\":true,\n" +
                        "            \"url\":\"https://api.github.com/repos/soshial/RxJava\",\n" +
                        "            \"forks_url\":\"https://api.github.com/repos/soshial/RxJava/forks\",\n" +
                        "            \"keys_url\":\"https://api.github.com/repos/soshial/RxJava/keys{/key_id}\",\n" +
                        "            \"collaborators_url\":\"https://api.github.com/repos/soshial/RxJava/collaborators{/collaborator}\",\n" +
                        "            \"teams_url\":\"https://api.github.com/repos/soshial/RxJava/teams\",\n" +
                        "            \"hooks_url\":\"https://api.github.com/repos/soshial/RxJava/hooks\",\n" +
                        "            \"issue_events_url\":\"https://api.github.com/repos/soshial/RxJava/issues/events{/number}\",\n" +
                        "            \"events_url\":\"https://api.github.com/repos/soshial/RxJava/events\",\n" +
                        "            \"assignees_url\":\"https://api.github.com/repos/soshial/RxJava/assignees{/user}\",\n" +
                        "            \"branches_url\":\"https://api.github.com/repos/soshial/RxJava/branches{/branch}\",\n" +
                        "            \"tags_url\":\"https://api.github.com/repos/soshial/RxJava/tags\",\n" +
                        "            \"blobs_url\":\"https://api.github.com/repos/soshial/RxJava/git/blobs{/sha}\",\n" +
                        "            \"git_tags_url\":\"https://api.github.com/repos/soshial/RxJava/git/tags{/sha}\",\n" +
                        "            \"git_refs_url\":\"https://api.github.com/repos/soshial/RxJava/git/refs{/sha}\",\n" +
                        "            \"trees_url\":\"https://api.github.com/repos/soshial/RxJava/git/trees{/sha}\",\n" +
                        "            \"statuses_url\":\"https://api.github.com/repos/soshial/RxJava/statuses/{sha}\",\n" +
                        "            \"languages_url\":\"https://api.github.com/repos/soshial/RxJava/languages\",\n" +
                        "            \"stargazers_url\":\"https://api.github.com/repos/soshial/RxJava/stargazers\",\n" +
                        "            \"contributors_url\":\"https://api.github.com/repos/soshial/RxJava/contributors\",\n" +
                        "            \"subscribers_url\":\"https://api.github.com/repos/soshial/RxJava/subscribers\",\n" +
                        "            \"subscription_url\":\"https://api.github.com/repos/soshial/RxJava/subscription\",\n" +
                        "            \"commits_url\":\"https://api.github.com/repos/soshial/RxJava/commits{/sha}\",\n" +
                        "            \"git_commits_url\":\"https://api.github.com/repos/soshial/RxJava/git/commits{/sha}\",\n" +
                        "            \"comments_url\":\"https://api.github.com/repos/soshial/RxJava/comments{/number}\",\n" +
                        "            \"issue_comment_url\":\"https://api.github.com/repos/soshial/RxJava/issues/comments{/number}\",\n" +
                        "            \"contents_url\":\"https://api.github.com/repos/soshial/RxJava/contents/{+path}\",\n" +
                        "            \"compare_url\":\"https://api.github.com/repos/soshial/RxJava/compare/{base}...{head}\",\n" +
                        "            \"merges_url\":\"https://api.github.com/repos/soshial/RxJava/merges\",\n" +
                        "            \"archive_url\":\"https://api.github.com/repos/soshial/RxJava/{archive_format}{/ref}\",\n" +
                        "            \"downloads_url\":\"https://api.github.com/repos/soshial/RxJava/downloads\",\n" +
                        "            \"issues_url\":\"https://api.github.com/repos/soshial/RxJava/issues{/number}\",\n" +
                        "            \"pulls_url\":\"https://api.github.com/repos/soshial/RxJava/pulls{/number}\",\n" +
                        "            \"milestones_url\":\"https://api.github.com/repos/soshial/RxJava/milestones{/number}\",\n" +
                        "            \"notifications_url\":\"https://api.github.com/repos/soshial/RxJava/notifications{?since,all,participating}\",\n" +
                        "            \"labels_url\":\"https://api.github.com/repos/soshial/RxJava/labels{/name}\",\n" +
                        "            \"releases_url\":\"https://api.github.com/repos/soshial/RxJava/releases{/id}\",\n" +
                        "            \"deployments_url\":\"https://api.github.com/repos/soshial/RxJava/deployments\",\n" +
                        "            \"created_at\":\"2018-10-10T10:37:11Z\",\n" +
                        "            \"updated_at\":\"2018-10-12T18:18:58Z\",\n" +
                        "            \"pushed_at\":\"2018-10-12T18:18:54Z\",\n" +
                        "            \"git_url\":\"git://github.com/soshial/RxJava.git\",\n" +
                        "            \"ssh_url\":\"git@github.com:soshial/RxJava.git\",\n" +
                        "            \"clone_url\":\"https://github.com/soshial/RxJava.git\",\n" +
                        "            \"svn_url\":\"https://github.com/soshial/RxJava\",\n" +
                        "            \"homepage\":\"\",\n" +
                        "            \"size\":68035,\n" +
                        "            \"stargazers_count\":0,\n" +
                        "            \"watchers_count\":0,\n" +
                        "            \"language\":\"Java\",\n" +
                        "            \"has_issues\":false,\n" +
                        "            \"has_projects\":true,\n" +
                        "            \"has_downloads\":true,\n" +
                        "            \"has_wiki\":true,\n" +
                        "            \"has_pages\":false,\n" +
                        "            \"forks_count\":0,\n" +
                        "            \"mirror_url\":null,\n" +
                        "            \"archived\":false,\n" +
                        "            \"open_issues_count\":0,\n" +
                        "            \"license\":{\n" +
                        "               \"key\":\"apache-2.0\",\n" +
                        "               \"name\":\"Apache License 2.0\",\n" +
                        "               \"spdx_id\":\"Apache-2.0\",\n" +
                        "               \"url\":\"https://api.github.com/licenses/apache-2.0\",\n" +
                        "               \"node_id\":\"MDc6TGljZW5zZTI=\"\n" +
                        "            },\n" +
                        "            \"forks\":0,\n" +
                        "            \"open_issues\":0,\n" +
                        "            \"watchers\":0,\n" +
                        "            \"default_branch\":\"2.x\"\n" +
                        "         }\n" +
                        "      },\n" +
                        "      \"base\":{\n" +
                        "         \"label\":\"ReactiveX:2.x\",\n" +
                        "         \"ref\":\"2.x\",\n" +
                        "         \"sha\":\"17f6e840e437ac90e81f2f2d369e25d4bcbde9ff\",\n" +
                        "         \"user\":{\n" +
                        "            \"login\":\"ReactiveX\",\n" +
                        "            \"id\":6407041,\n" +
                        "            \"node_id\":\"MDEyOk9yZ2FuaXphdGlvbjY0MDcwNDE=\",\n" +
                        "            \"avatar_url\":\"https://avatars1.githubusercontent.com/u/6407041?v=4\",\n" +
                        "            \"gravatar_id\":\"\",\n" +
                        "            \"url\":\"https://api.github.com/users/ReactiveX\",\n" +
                        "            \"html_url\":\"https://github.com/ReactiveX\",\n" +
                        "            \"followers_url\":\"https://api.github.com/users/ReactiveX/followers\",\n" +
                        "            \"following_url\":\"https://api.github.com/users/ReactiveX/following{/other_user}\",\n" +
                        "            \"gists_url\":\"https://api.github.com/users/ReactiveX/gists{/gist_id}\",\n" +
                        "            \"starred_url\":\"https://api.github.com/users/ReactiveX/starred{/owner}{/repo}\",\n" +
                        "            \"subscriptions_url\":\"https://api.github.com/users/ReactiveX/subscriptions\",\n" +
                        "            \"organizations_url\":\"https://api.github.com/users/ReactiveX/orgs\",\n" +
                        "            \"repos_url\":\"https://api.github.com/users/ReactiveX/repos\",\n" +
                        "            \"events_url\":\"https://api.github.com/users/ReactiveX/events{/privacy}\",\n" +
                        "            \"received_events_url\":\"https://api.github.com/users/ReactiveX/received_events\",\n" +
                        "            \"type\":\"Organization\",\n" +
                        "            \"site_admin\":false\n" +
                        "         },\n" +
                        "         \"repo\":{\n" +
                        "            \"id\":7508411,\n" +
                        "            \"node_id\":\"MDEwOlJlcG9zaXRvcnk3NTA4NDEx\",\n" +
                        "            \"name\":\"RxJava\",\n" +
                        "            \"full_name\":\"ReactiveX/RxJava\",\n" +
                        "            \"private\":false,\n" +
                        "            \"owner\":{\n" +
                        "               \"login\":\"ReactiveX\",\n" +
                        "               \"id\":6407041,\n" +
                        "               \"node_id\":\"MDEyOk9yZ2FuaXphdGlvbjY0MDcwNDE=\",\n" +
                        "               \"avatar_url\":\"https://avatars1.githubusercontent.com/u/6407041?v=4\",\n" +
                        "               \"gravatar_id\":\"\",\n" +
                        "               \"url\":\"https://api.github.com/users/ReactiveX\",\n" +
                        "               \"html_url\":\"https://github.com/ReactiveX\",\n" +
                        "               \"followers_url\":\"https://api.github.com/users/ReactiveX/followers\",\n" +
                        "               \"following_url\":\"https://api.github.com/users/ReactiveX/following{/other_user}\",\n" +
                        "               \"gists_url\":\"https://api.github.com/users/ReactiveX/gists{/gist_id}\",\n" +
                        "               \"starred_url\":\"https://api.github.com/users/ReactiveX/starred{/owner}{/repo}\",\n" +
                        "               \"subscriptions_url\":\"https://api.github.com/users/ReactiveX/subscriptions\",\n" +
                        "               \"organizations_url\":\"https://api.github.com/users/ReactiveX/orgs\",\n" +
                        "               \"repos_url\":\"https://api.github.com/users/ReactiveX/repos\",\n" +
                        "               \"events_url\":\"https://api.github.com/users/ReactiveX/events{/privacy}\",\n" +
                        "               \"received_events_url\":\"https://api.github.com/users/ReactiveX/received_events\",\n" +
                        "               \"type\":\"Organization\",\n" +
                        "               \"site_admin\":false\n" +
                        "            },\n" +
                        "            \"html_url\":\"https://github.com/ReactiveX/RxJava\",\n" +
                        "            \"description\":\"RxJava – Reactive Extensions for the JVM – a library for composing asynchronous and event-based programs using observable sequences for the Java VM.\",\n" +
                        "            \"fork\":false,\n" +
                        "            \"url\":\"https://api.github.com/repos/ReactiveX/RxJava\",\n" +
                        "            \"forks_url\":\"https://api.github.com/repos/ReactiveX/RxJava/forks\",\n" +
                        "            \"keys_url\":\"https://api.github.com/repos/ReactiveX/RxJava/keys{/key_id}\",\n" +
                        "            \"collaborators_url\":\"https://api.github.com/repos/ReactiveX/RxJava/collaborators{/collaborator}\",\n" +
                        "            \"teams_url\":\"https://api.github.com/repos/ReactiveX/RxJava/teams\",\n" +
                        "            \"hooks_url\":\"https://api.github.com/repos/ReactiveX/RxJava/hooks\",\n" +
                        "            \"issue_events_url\":\"https://api.github.com/repos/ReactiveX/RxJava/issues/events{/number}\",\n" +
                        "            \"events_url\":\"https://api.github.com/repos/ReactiveX/RxJava/events\",\n" +
                        "            \"assignees_url\":\"https://api.github.com/repos/ReactiveX/RxJava/assignees{/user}\",\n" +
                        "            \"branches_url\":\"https://api.github.com/repos/ReactiveX/RxJava/branches{/branch}\",\n" +
                        "            \"tags_url\":\"https://api.github.com/repos/ReactiveX/RxJava/tags\",\n" +
                        "            \"blobs_url\":\"https://api.github.com/repos/ReactiveX/RxJava/git/blobs{/sha}\",\n" +
                        "            \"git_tags_url\":\"https://api.github.com/repos/ReactiveX/RxJava/git/tags{/sha}\",\n" +
                        "            \"git_refs_url\":\"https://api.github.com/repos/ReactiveX/RxJava/git/refs{/sha}\",\n" +
                        "            \"trees_url\":\"https://api.github.com/repos/ReactiveX/RxJava/git/trees{/sha}\",\n" +
                        "            \"statuses_url\":\"https://api.github.com/repos/ReactiveX/RxJava/statuses/{sha}\",\n" +
                        "            \"languages_url\":\"https://api.github.com/repos/ReactiveX/RxJava/languages\",\n" +
                        "            \"stargazers_url\":\"https://api.github.com/repos/ReactiveX/RxJava/stargazers\",\n" +
                        "            \"contributors_url\":\"https://api.github.com/repos/ReactiveX/RxJava/contributors\",\n" +
                        "            \"subscribers_url\":\"https://api.github.com/repos/ReactiveX/RxJava/subscribers\",\n" +
                        "            \"subscription_url\":\"https://api.github.com/repos/ReactiveX/RxJava/subscription\",\n" +
                        "            \"commits_url\":\"https://api.github.com/repos/ReactiveX/RxJava/commits{/sha}\",\n" +
                        "            \"git_commits_url\":\"https://api.github.com/repos/ReactiveX/RxJava/git/commits{/sha}\",\n" +
                        "            \"comments_url\":\"https://api.github.com/repos/ReactiveX/RxJava/comments{/number}\",\n" +
                        "            \"issue_comment_url\":\"https://api.github.com/repos/ReactiveX/RxJava/issues/comments{/number}\",\n" +
                        "            \"contents_url\":\"https://api.github.com/repos/ReactiveX/RxJava/contents/{+path}\",\n" +
                        "            \"compare_url\":\"https://api.github.com/repos/ReactiveX/RxJava/compare/{base}...{head}\",\n" +
                        "            \"merges_url\":\"https://api.github.com/repos/ReactiveX/RxJava/merges\",\n" +
                        "            \"archive_url\":\"https://api.github.com/repos/ReactiveX/RxJava/{archive_format}{/ref}\",\n" +
                        "            \"downloads_url\":\"https://api.github.com/repos/ReactiveX/RxJava/downloads\",\n" +
                        "            \"issues_url\":\"https://api.github.com/repos/ReactiveX/RxJava/issues{/number}\",\n" +
                        "            \"pulls_url\":\"https://api.github.com/repos/ReactiveX/RxJava/pulls{/number}\",\n" +
                        "            \"milestones_url\":\"https://api.github.com/repos/ReactiveX/RxJava/milestones{/number}\",\n" +
                        "            \"notifications_url\":\"https://api.github.com/repos/ReactiveX/RxJava/notifications{?since,all,participating}\",\n" +
                        "            \"labels_url\":\"https://api.github.com/repos/ReactiveX/RxJava/labels{/name}\",\n" +
                        "            \"releases_url\":\"https://api.github.com/repos/ReactiveX/RxJava/releases{/id}\",\n" +
                        "            \"deployments_url\":\"https://api.github.com/repos/ReactiveX/RxJava/deployments\",\n" +
                        "            \"created_at\":\"2013-01-08T20:11:48Z\",\n" +
                        "            \"updated_at\":\"2018-10-14T22:03:08Z\",\n" +
                        "            \"pushed_at\":\"2018-10-12T18:18:58Z\",\n" +
                        "            \"git_url\":\"git://github.com/ReactiveX/RxJava.git\",\n" +
                        "            \"ssh_url\":\"git@github.com:ReactiveX/RxJava.git\",\n" +
                        "            \"clone_url\":\"https://github.com/ReactiveX/RxJava.git\",\n" +
                        "            \"svn_url\":\"https://github.com/ReactiveX/RxJava\",\n" +
                        "            \"homepage\":\"\",\n" +
                        "            \"size\":68109,\n" +
                        "            \"stargazers_count\":35794,\n" +
                        "            \"watchers_count\":35794,\n" +
                        "            \"language\":\"Java\",\n" +
                        "            \"has_issues\":true,\n" +
                        "            \"has_projects\":true,\n" +
                        "            \"has_downloads\":true,\n" +
                        "            \"has_wiki\":true,\n" +
                        "            \"has_pages\":true,\n" +
                        "            \"forks_count\":6171,\n" +
                        "            \"mirror_url\":null,\n" +
                        "            \"archived\":false,\n" +
                        "            \"open_issues_count\":25,\n" +
                        "            \"license\":{\n" +
                        "               \"key\":\"apache-2.0\",\n" +
                        "               \"name\":\"Apache License 2.0\",\n" +
                        "               \"spdx_id\":\"Apache-2.0\",\n" +
                        "               \"url\":\"https://api.github.com/licenses/apache-2.0\",\n" +
                        "               \"node_id\":\"MDc6TGljZW5zZTI=\"\n" +
                        "            },\n" +
                        "            \"forks\":6171,\n" +
                        "            \"open_issues\":25,\n" +
                        "            \"watchers\":35794,\n" +
                        "            \"default_branch\":\"2.x\"\n" +
                        "         }\n" +
                        "      },\n" +
                        "      \"_links\":{\n" +
                        "         \"self\":{\n" +
                        "            \"href\":\"https://api.github.com/repos/ReactiveX/RxJava/pulls/6242\"\n" +
                        "         },\n" +
                        "         \"html\":{\n" +
                        "            \"href\":\"https://github.com/ReactiveX/RxJava/pull/6242\"\n" +
                        "         },\n" +
                        "         \"issue\":{\n" +
                        "            \"href\":\"https://api.github.com/repos/ReactiveX/RxJava/issues/6242\"\n" +
                        "         },\n" +
                        "         \"comments\":{\n" +
                        "            \"href\":\"https://api.github.com/repos/ReactiveX/RxJava/issues/6242/comments\"\n" +
                        "         },\n" +
                        "         \"review_comments\":{\n" +
                        "            \"href\":\"https://api.github.com/repos/ReactiveX/RxJava/pulls/6242/comments\"\n" +
                        "         },\n" +
                        "         \"review_comment\":{\n" +
                        "            \"href\":\"https://api.github.com/repos/ReactiveX/RxJava/pulls/comments{/number}\"\n" +
                        "         },\n" +
                        "         \"commits\":{\n" +
                        "            \"href\":\"https://api.github.com/repos/ReactiveX/RxJava/pulls/6242/commits\"\n" +
                        "         },\n" +
                        "         \"statuses\":{\n" +
                        "            \"href\":\"https://api.github.com/repos/ReactiveX/RxJava/statuses/cb5e8cd1d177b81ade76943ec5cbd26b34670de8\"\n" +
                        "         }\n" +
                        "      },\n" +
                        "      \"author_association\":\"NONE\"\n" +
                        "   }\n" +
                        "]"
    }
}